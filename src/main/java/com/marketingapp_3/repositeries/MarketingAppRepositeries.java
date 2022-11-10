package com.marketingapp_3.repositeries;

import org.springframework.data.jpa.repository.JpaRepository;

import com.marketingapp_3.entities.Lead;

public interface MarketingAppRepositeries extends JpaRepository<Lead, Long> {

}
