package com.example.springkadaiform.controller;

import org.springframework.core.Conventions;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.springkadaiform.form.ContactForm;

@Controller
public class ContactFormController {
	//http//:localhost:8080/form
	@GetMapping("/form")
	public String form(Model model) {
		model.addAttribute("contactForm", new ContactForm());
		return "contactFormView";
	}
	
	@PostMapping("/confirm")
	public String register(RedirectAttributes redirectAttributes,
            @Validated ContactForm form, BindingResult result) {
		// バリデーションエラーがあったら終了
        if (result.hasErrors()) {
            // フォームクラスをビューに受け渡す
            redirectAttributes.addFlashAttribute("contactForm", form);
            // バリデーション結果をビューに受け渡す
            redirectAttributes.addFlashAttribute(BindingResult.MODEL_KEY_PREFIX
                    + Conventions.getVariableName(form), result);
            // adにリダイレクトしてリストを再表示
         	return "redirect:/form";
        }
	return "confirmView";
}
        
		//ご確認内容表示
    /*  @PostMapping("/confirm")
        public String confirm(ContactForm form, Model model) {
    	  model.addAttribute("confirmForm", form);
        	return "confirmView";
        } */
       
	

}
