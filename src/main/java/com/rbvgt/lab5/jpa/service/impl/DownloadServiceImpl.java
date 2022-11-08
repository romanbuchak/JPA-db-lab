package com.rbvgt.lab5.jpa.service.impl;

import com.rbvgt.lab5.jpa.exception.DownloadNotFoundException;
import com.rbvgt.lab5.jpa.model.Download;
import com.rbvgt.lab5.jpa.repository.DownloadRepository;
import com.rbvgt.lab5.jpa.service.DownloadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;

@Service
public class DownloadServiceImpl implements DownloadService {

    @Autowired
    DownloadRepository downloadRepository;

    @Override
    public List<Download> findAll() {
        return downloadRepository.findAll();
    }

    @Override
    public Download findById(Integer id) {
        return downloadRepository.findById(id)
                .orElseThrow(() -> new DownloadNotFoundException(id));
    }

    @Override
    public Integer getAveragePrice() {
        return downloadRepository.getAveragePrice();
    }

    @Transactional
    public Download create(Download download) {
        downloadRepository.save(download);
        return download;
    }

    @Transactional
    public void update(Integer id, Download uDownload) {
        Download author = downloadRepository.findById(id)
                .orElseThrow(() -> new DownloadNotFoundException(id));
        //update
        author.setId(uDownload.getId());
        author.setPrice(uDownload.getPrice());
        author.setQuantity(uDownload.getQuantity());

        downloadRepository.save(uDownload);
    }

    @Transactional
    public void delete(Integer id) {
        Download author = downloadRepository.findById(id)
                .orElseThrow(() -> new DownloadNotFoundException(id));
        downloadRepository.delete(author);
    }
}
