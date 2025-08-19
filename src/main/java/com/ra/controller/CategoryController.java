package com.ra.controller;

import com.ra.model.Category;
import com.ra.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @GetMapping
    public String listCategory(Model model) {
        model.addAttribute("categories", categoryService.findAll());
        return "listCategory";
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("category", new Category());
        return "addCategory";
    }

    @PostMapping("/add")
    public String addCategory(@ModelAttribute Category category, Model model, RedirectAttributes redirectAttributes) {
        if (category.getCateName() == null || category.getCateName().isEmpty()) {
            model.addAttribute("category", new Category());
            return "addCategory";
        } else if (categoryService.findByName(category.getCateName())) {
            model.addAttribute("category", category);
            return "addCategory";
        }
        categoryService.save(category);
        redirectAttributes.addFlashAttribute("message", "Thêm danh mục thành công");
        return "redirect:/category";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable("id") Long id, Model model) {
        Category category = categoryService.findById(id);
        model.addAttribute("category", category);
        return "editCategory";
    }

    @PostMapping("/edit/{id}")
    public String editCategory(@PathVariable("id") Long id, @ModelAttribute Category category, Model model) {
        Category outCategory = categoryService.findById(id);
        if (categoryService.findByName(category.getCateName()) && !category.getCateId().equals(id)) {
            model.addAttribute("error", "Tên danh mục đã tồn tai");
            return "editCategory";
        } else if (categoryService.findByName(category.getCateName()) && !category.getCateName().equalsIgnoreCase(outCategory.getCateName())) {
            model.addAttribute("category", category);
            model.addAttribute("error", "Tên danh mục đã tồn tại");
            return "addCategory";
        }
        category.setCateId(id);
        categoryService.save(category);
        model.addAttribute("message","Cập nhật thành công");
        return "redirect:/category";
    }
    @GetMapping("delete/{id}")
    public String deleteCategory(@PathVariable("id") Long id ){
        categoryService.deleteById(id);
        return "redirect:/category";
    }


}
