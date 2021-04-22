package io.xiaomo.demo.service.impl;

import org.springframework.stereotype.Service;
import io.xiaomo.demo.service.ConfigService;

@Service
public class ConfigServiceImpl implements ConfigService , ConfigServiceImplMBean{

    private boolean isOpen;

    @Override
    public void open() {
        this.isOpen = true;
    }

    @Override
    public void close() {
        this.isOpen = false;
    }

    @Override
    public boolean isOpen() {
        return this.isOpen;
    }
}
