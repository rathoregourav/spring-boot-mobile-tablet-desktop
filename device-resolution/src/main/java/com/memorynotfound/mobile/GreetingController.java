package com.memorynotfound.mobile;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.mobile.device.Device;
import org.springframework.mobile.device.DeviceUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class GreetingController {

    private static final Logger log = LoggerFactory.getLogger(GreetingController.class);

    @RequestMapping("/")
    public String greeting(Device device, HttpServletRequest request) {

        Device deviceFromRequest = DeviceUtils.getCurrentDevice(request);

        if (device.isMobile()) {
            log.info("Hello mobile user!");
        } else if (device.isTablet()) {
            log.info("Hello tablet user!");
        } else {
            log.info("Hello desktop user!");
        }

        log.info("device: " + device);
        log.info("device form request: " + deviceFromRequest);
        log.info("device platform: " + device.getDevicePlatform());

        return "greeting";
    }

}
