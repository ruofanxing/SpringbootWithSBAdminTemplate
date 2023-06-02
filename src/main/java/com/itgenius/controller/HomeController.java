package com.itgenius.controller;

import cn.hutool.poi.excel.ExcelUtil;
import cn.hutool.poi.excel.ExcelWriter;
import com.itgenius.beans.Product;
import com.itgenius.repository.ProductDao;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

@Controller
public class HomeController {
	@Autowired //injetar o repositório no controller
	private ProductDao productDao;
	@GetMapping("/")
	public String login() {
		return "login";
	}

	@GetMapping("/register")
	public String register() {
		return "register";
	}

	@GetMapping("/forgotpassword")
	public String forgotpassword() {
		return "forgotpassword";
	}

	@GetMapping("/dashboard")
	public String dashboard() {
		return "dashboard";
	}

	@GetMapping("/category")
	public String category(Model model) {
		List<Product> prods=productDao.findAll();
		model.addAttribute("prods",prods);
		return "category";
	}
}
