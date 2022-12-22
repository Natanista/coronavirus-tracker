package com.example.coronavirustracker.services.controllers;

import com.example.coronavirustracker.services.CoronaVirusDataService;
import com.example.coronavirustracker.services.models.LocationStats;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.List;
@Controller
public class HomeController {

    @Autowired
    CoronaVirusDataService coronaVirusDataService;

    @GetMapping("/")
    public String home(Model model){
        List<LocationStats> allStats = coronaVirusDataService.getAllStats();
       int totalReportedCases = allStats.stream().mapToInt(stat -> stat.getLatestTotal()).sum();
       int totalNewCases = allStats.stream().mapToInt(stat -> stat.getDiffFromPrevDay()).sum();
         model.addAttribute("locationStats", allStats);
         model.addAttribute("totalNewCases", totalNewCases);
         model.addAttribute("totalReportedCases", totalReportedCases);

        return "home";
    }
}