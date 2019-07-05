package com.kam.my;

import java.util.List;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.AbstractLoadBalancer;
import com.netflix.loadbalancer.AbstractLoadBalancerRule;
import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.Server;

public class Rule_ZY extends AbstractLoadBalancerRule {

	int total = 0;
	int currentIndex =0;
	
	public Server choose(ILoadBalancer lb,Object key) {
		
		if(lb==null) {
			return null;
		}
		Server server = null;
		while(server == null) {
			if(Thread.interrupted()) {
				return null;
			}
			
			List<Server> upList = lb.getReachableServers();//得到可用的服务
			List<Server> allList = lb.getAllServers(); // 得到全部的服务
			int serverCount = allList.size();
			if(serverCount==0) {
				
				return null;
			}
			if(total<5) {
				server = upList.get(currentIndex);
				total++;
			}else {
				total =0;
				currentIndex++;
				if(currentIndex>=upList.size()) {
					currentIndex=0;
				}
			}
			if(server == null) {
				
				Thread.yield();
				continue;
			}
			if(server.isAlive()) {
				return (server);
			}
			server = null;
			Thread.yield();
		}
		
		
		
		return server;
	}

	@Override
	public void initWithNiwsConfig(IClientConfig clientConfig) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Server choose(Object key) {
		// TODO Auto-generated method stub
		return choose(getLoadBalancer(), key);
	}

	
}
