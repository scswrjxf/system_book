package com.book.controller;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.book.pojo.Category; 
import com.book.service.BookService;
import com.mysql.jdbc.StringUtils; 

@WebServlet("/add_book")
public class AddBookAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BookService bookService = new BookService();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			// 声明接收数据的变量
			String bookName = null;
			String author = null;
			String publisher = null;
			Double price = null;
			Category bookCategory = null;
			String bphoto = null;
			// 获取上传文件的目录(这里表示上传文件的目录为/upload)
			String realPath = getServletContext().getRealPath("/upload");
			// 为基于磁盘的文件项创建DiskFileItemFactory对象
			DiskFileItemFactory factory = new DiskFileItemFactory();
			// 配置存储库（配置文件上传的临时存放位置）
			ServletContext servletContext = this.getServletConfig().getServletContext();
			File repository = (File) servletContext.getAttribute("javax.servlet.context.tempdir");
			factory.setRepository(repository);
			// 创建新的文件上载处理程序
			ServletFileUpload upload = new ServletFileUpload(factory);
			// 设置总请求大小约束（字节）
			upload.setSizeMax(100 * 1024 * 1024); // 100M 1byte=8bit 1kb=1024byte 1M=1024kb
			// 设置保存文件的编码方式，
			upload.setHeaderEncoding("UTF-8");
			// 分析请求，把请求参数封装成FileItem类的对象，放入List中(相当于ArrayList)
			List<FileItem> items = upload.parseRequest(request);
			// 遍历list，分别处理每个上传参数
			Iterator<FileItem> iter = items.iterator();
			while (iter.hasNext()) {
				FileItem item = iter.next();// 得到当前项，类型为FileItem
				if (item.isFormField()) { // 批判内容是否是普通文本(非文件内容)
					String name = item.getFieldName();// 获取参数名称 userId
					String value = item.getString();// 获取值
					if(StringUtils.isNullOrEmpty(value)) {
						request.setAttribute("message","内容不能为空");
						request.getRequestDispatcher("/book_mgr.jsp").forward(request, response);
						return;
					}
					if(name.equals("btitle"))
						bookName = new String(value.getBytes("ISO-8859-1"),"utf-8");
					else if(name.equals("bauthor"))
						author = new String(value.getBytes("ISO-8859-1"),"utf-8");
					else if(name.equals("btypeid"))
						bookCategory = new Category(Integer.valueOf(value),null);
					else if(name.equals("bprice"))
						price = Double.valueOf(value);
					else
						publisher = new String(value.getBytes("ISO-8859-1"),"utf-8");
				} else { // 上传的文件数据
					String fileName = item.getName(); // 获取文件名
					String contentType = item.getContentType();// 获取文件的MIME类型
					// 只能上传的是图片
					if(contentType.equals("image/png") 
							|| contentType.equals("image/gif")
							|| contentType.equals("image/jpeg")) {
						String rand = UUID.randomUUID().toString();// 获取一个UUID值
						// 上传文件(包含了上传目录和文件名称)
						bphoto = rand + fileName;
						File uploadedFile = new File(realPath, bphoto);
						item.write(uploadedFile);// 把文件保存到上传目录
					}
					else {// 上传的不是图片
						request.setAttribute("message","只能上传图片");
						request.getRequestDispatcher("/book_mgr.jsp").forward(request, response);
						return;
					}
				}
			} 
			int result =bookService.addBookInfo(bookName, author, bookCategory.getId(), publisher, price, bphoto);
			if(result != 0) {
				request.setAttribute("message","添加书籍成功");
				request.getRequestDispatcher("/book_mgr").forward(request,response);
				return;
			}
			else {
				request.setAttribute("message","添加书籍失败");
				request.getRequestDispatcher("/book_mgr").forward(request,response);
				return;
			}  
		} catch (Exception e) {
			e.printStackTrace();
		}
	} 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
