package pl.portofilm.project.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminController {

    public static final String NOTIFICATION_ATTRIBUTE = "notification";

    @GetMapping("/admin")
    String getAdminPanel() {
        return "admin/admin";
    }
}
