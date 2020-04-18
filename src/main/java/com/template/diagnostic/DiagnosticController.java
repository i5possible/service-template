package com.template.diagnostic;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author lianghongbuaa@gmail.com
 */
@Controller
@RequestMapping("/diagnostic")
public class DiagnosticController {

    @Value("${version}")
    private String applicationVersion;

    @RequestMapping("/status/heartbeat")
    public ResponseEntity<String> handleHeartbeat() {
        return new ResponseEntity<>("OK", HttpStatus.OK);
    }

    @RequestMapping("/version")
    public ResponseEntity<String> getVersion() {
        return new ResponseEntity<>(this.applicationVersion, HttpStatus.OK);
    }
}
