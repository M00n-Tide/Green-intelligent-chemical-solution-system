package com.lumap.repository;

import com.lumap.entity.RiskMonitor;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface RiskMonitorRepository extends JpaRepository<RiskMonitor, Long> {
    List<RiskMonitor> findByMonitorStatus(RiskMonitor.MonitorStatus status);
}