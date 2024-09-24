package com.sacv.projects.monitoringsystem.app;

import org.springframework.boot.SpringApplication;

public class TestMonitoringSystemApplication {

    public static void main(String[] args) {
        SpringApplication.from(MonitoringSystemApplication::main).with(TestcontainersConfiguration.class).run(args);
    }

}
