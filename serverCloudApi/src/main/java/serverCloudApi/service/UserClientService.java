package serverCloudApi.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

//@FeignClient(value="SERVER-PROVIDER-USER")

@FeignClient(value="SERVER-PROVIDER-USER",fallbackFactory=UserClientServicefallback.class)
public interface UserClientService {

	@RequestMapping("/findList")
	public Object getList();
	
	@RequestMapping("/fuwufaxian")
	public Object getfu();
	
}
