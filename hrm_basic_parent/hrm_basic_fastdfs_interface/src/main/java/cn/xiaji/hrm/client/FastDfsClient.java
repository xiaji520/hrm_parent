package cn.xiaji.hrm.client;

import cn.xiaji.hrm.util.AjaxResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.FeignClientsConfiguration;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@FeignClient(value = "ZUUL-GATEWAY", configuration = FeignClientsConfiguration.class,
        fallbackFactory = FastDfsClientHystrixFallbackFactory.class
)
@RequestMapping("/fastdfs")
public interface FastDfsClient {
    @PostMapping()
    String upload(@RequestBody MultipartFile file);

    @DeleteMapping
    AjaxResult delete(@RequestParam("path") String path);

    @GetMapping
    void download(@RequestParam("path") String path);

}
