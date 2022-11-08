package com.rbvgt.lab5.jpa.service;

import com.rbvgt.lab5.jpa.model.Download;

public interface DownloadService extends GeneralService<Download, Integer> {
    Integer getAveragePrice();
}
