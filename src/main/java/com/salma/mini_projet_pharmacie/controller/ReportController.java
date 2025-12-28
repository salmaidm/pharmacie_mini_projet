package com.salma.mini_projet_pharmacie.controller;

import com.salma.mini_projet_pharmacie.service.ReportService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/reports")
public class ReportController {

    private final ReportService reportService;

    public ReportController(ReportService reportService) {
        this.reportService = reportService;
    }

    @GetMapping("/ventes")
    public Object rapportVentes() {
        return reportService.getRapportVentes();
    }

    @GetMapping("/stock")
    public Object rapportStock() {
        return reportService.getRapportStock();
    }
}
