package info.chen.microservice.rule;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.AbstractLoadBalancerRule;
import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.Server;

import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

public class CustomRule extends AbstractLoadBalancerRule {

    private AtomicInteger currentIndex = new AtomicInteger(0);
    private AtomicInteger count = new AtomicInteger(0);
    Random random;

    public CustomRule() {
        random = new Random();
    }

    @Override
    public void initWithNiwsConfig(IClientConfig iClientConfig) {

    }

    @Override
    public Server choose(Object key) {
        return choose(getLoadBalancer(), key);
    }

    public Server choose(ILoadBalancer lb, Object key) {
        if (lb == null) {
            return null;
        }
        Server server = null;

        while (server == null) {
            if (Thread.interrupted()) {
                return null;
            }
            List<Server> upList = lb.getReachableServers();
            List<Server> allList = lb.getAllServers();

            int serverCount = allList.size();
            if (serverCount == 0) {
                /*
                 * No servers. End regardless of pass, because subsequent passes
                 * only get more restrictive.
                 */
                return null;
            }

            if (count.getAndIncrement() < 5) {
                if (upList.size() <= currentIndex.get()) {
                    currentIndex.set(0);
                }
                server = upList.get(currentIndex.get());
            } else {
                count.set(0);

                if (upList.size() <= currentIndex.get()) {
                    currentIndex.set(0);
                }
                server = upList.get(currentIndex.getAndIncrement());
            }

            if (server == null) {
                /*
                 * The only time this should happen is if the server list were
                 * somehow trimmed. This is a transient condition. Retry after
                 * yielding.
                 */
                Thread.yield();
                continue;
            }

            if (server.isAlive()) {
                return (server);
            }

            // Shouldn't actually happen.. but must be transient or a bug.
            server = null;
            Thread.yield();
        }

        return server;

    }
}
