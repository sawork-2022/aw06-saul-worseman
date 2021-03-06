package com.example.batch.service;

import com.example.batch.model.Product;
import com.example.batch.repository.ProductRepository;
import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.StepExecutionListener;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ProductWriter implements ItemWriter<Product>, StepExecutionListener {

    @Autowired
    ProductRepository productRepository;

    @Override
    public void beforeStep(StepExecution stepExecution) {

    }

    @Override
    public ExitStatus afterStep(StepExecution stepExecution) {
        return null;
    }

    @Override
    public void write(List<? extends Product> list) throws Exception {
        // System.out.println(list.size());
//        list.stream().forEach(System.out::println);
//        System.out.println("chunk written");
        productRepository.saveAll(list);
//        List<Product> li = productRepository.findAll();
        //System.out.println(li.size());
    }
}
