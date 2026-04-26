package com.lexitrace.services;

import com.lexitrace.dao.AuditLogRepository;
import com.lexitrace.models.AuditLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class AuditLogService {

    @Autowired
    private AuditLogRepository auditLogRepository;

    public void log(Long adminId, String action, Long targetUserId) {
        auditLogRepository.save(new AuditLog(adminId, action, targetUserId));
    }

    public List<AuditLog> getAllLogs() {
        return auditLogRepository.findAllByOrderByTimestampDesc();
    }
}
