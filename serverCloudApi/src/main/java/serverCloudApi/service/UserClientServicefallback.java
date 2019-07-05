package serverCloudApi.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

import feign.hystrix.FallbackFactory;
import serverCloudApi.entitys.User;

@Component // 一定要添加
//implements FallbackFactory<UserClientService>
public class UserClientServicefallback implements FallbackFactory<UserClientService> {

	@Override
	public UserClientService create(Throwable cause) {
		// TODO Auto-generated method stub
		return new UserClientService() {

			@Override
			public Object getList() {
				// TODO Auto-generated method stub
				List<User> ji = new ArrayList<User>();
				User uu = new User();
				uu.setDbSource("没有信息");
				uu.setName("没有信息");
				uu.setPass("没有信息");
				ji.add(uu);
				return ji;
			}

			@Override
			public Object getfu() {
				// TODO Auto-generated method stub
				return null;
			}
			
		};
	}

	

}
