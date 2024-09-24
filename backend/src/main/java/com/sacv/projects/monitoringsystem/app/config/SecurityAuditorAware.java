package com.sacv.projects.monitoringsystem.app.config;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.data.domain.AuditorAware;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.util.Optional;

public class SecurityAuditorAware implements AuditorAware<String> {

    private final String HEADER_USER="X-User-Name";

    @Override
    public Optional<String> getCurrentAuditor() {
        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
        if (requestAttributes instanceof ServletRequestAttributes) {
            HttpServletRequest request = ((ServletRequestAttributes) requestAttributes).getRequest();
            String auditorHeader = request.getHeader(HEADER_USER);
            if (auditorHeader != null && !auditorHeader.isEmpty()) {
                return Optional.of(auditorHeader);
            }
        }
        return Optional.of("anonymous");
    }
}
