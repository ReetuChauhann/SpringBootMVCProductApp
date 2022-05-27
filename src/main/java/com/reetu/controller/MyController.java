package com.reetu.controller;

import java.io.InputStream;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.reetu.beans.Product;
import com.reetu.dao.ProductRepo;

@Controller
public class MyController {
	@Autowired
    ProductRepo pr;

    @RequestMapping("/")
    public String home() {
 	   return "index";
    }
    @RequestMapping("/updateproductbyId")
    public String updateproductbyId() {

 	   return "updateproductbyId";

    }
    
    @RequestMapping("/getAllProducts")
    public String getAllProducts(Model model) {

 	   List<Product> p= pr.getAllProduct();
 	   model.addAttribute("Data",p);

 	   return "GetAllProducts";

    }
    @RequestMapping("/addProduct")
//     public String addProduct(int pid,int pprice,String pname,String preview, Model model) {
//    Product p = new Product();
//    p.setPid(pid);
//    p.setPprice(pprice);
//    p.setPname(pname);
//    p.setPreview(preview);
    
   public String addProduct(@ModelAttribute Product p, Model model, Part image) {
    	InputStream n1=null;
    	try {
    		
        	if(image!=null) {
        		n1=image.getInputStream();
        	}
		} catch (Exception e) {
			e.printStackTrace();
			
		}
    	   String result = pr.addproduct(p,n1);
    	   model.addAttribute("result", result);
    	   return "index";
    	
    
    }
    
    @RequestMapping("/getProductbyId")
    public String getProductbyId(int pid,Model model) {
    	Product p = pr.getproductbyId(pid);
    	model.addAttribute("result", p);
    	return "GetProductbyID";
    }
      
    @RequestMapping("/getProductlikename")
    public String getProductLikeName(String pname, Model model) {
    	List<Product> p = pr.getproductlikeName(pname);
    	model.addAttribute("result",p);
    	return "GetProductLikeName";
    }
    
    @RequestMapping("/deleteProduct")
    public String deleteProduct(int pid, Model model) {
    	 String s = pr.deleteproduct(pid);
    	 model.addAttribute("key",s);
    	 return "index";
    }
    
    @ModelAttribute //it is like servlet context available for every jsp 
    public void commonValue(Model m) {
    	List<String> p = pr.getallproductsname();
    	m.addAttribute("pname", p);
    	
    	List<Integer> p2= pr.getallproductsId();
    	m.addAttribute("Pid", p2);
    	
   }
    @RequestMapping("/updateProduct")
    public String updateProduct(@ModelAttribute Product p,String pname1, Model model) {
    	String s = pr.updateproduct(pname1, p);
    	model.addAttribute("update", s);
    	return "index";
    }
    
       
        @RequestMapping("/updateProductbyId")
        public String updateproductbyId(@ModelAttribute Product p, Model model) {
        	String s = pr.updateproductbyId(p);
        	model.addAttribute("update",s);
        	return "updateproductbyId";
        }
        @RequestMapping("getimage")
        public void getimage(int pid, HttpServletResponse response) {
        	try {
        		  byte[] b=pr.getimage(pid);
            	  response.getOutputStream().write(b);

		} catch (Exception e) {
				e.printStackTrace();
			}       
       }
}