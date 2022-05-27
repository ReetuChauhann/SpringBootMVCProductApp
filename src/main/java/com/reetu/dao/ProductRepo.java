package com.reetu.dao;

import java.io.InputStream;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.reetu.beans.Product;

@Repository
public class ProductRepo {

	@Autowired
	JdbcTemplate jdbcTemplate;

	// to add product
	public String addproduct(Product p, InputStream image) {
		try {
			String query = "insert into detail values(?,?,?,?,?)";
			jdbcTemplate.update(query, new Object[] { p.getPid(), p.getPprice(), p.getPname(), p.getPreview(), image});
			return "Success";

		} catch (Exception e) {
			return "failed";
		}
	}

	// to view getAllproduct
	public List<Product> getAllProduct() {

		class ProductMapper implements RowMapper {

			@Override
			public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
				Product p = new Product();
				p.setPid(rs.getInt("pid"));
				p.setPprice(rs.getInt("pprice"));
				p.setPname(rs.getString("pname"));
				p.setPreview(rs.getString("preview"));

				return p;
			}

		}
		final String query = "select *  from detail";
		List<Product> p = jdbcTemplate.query(query, new ProductMapper());
		return p;
	}
	// get product by id

	public Product getproductbyId(int id) {

		class ProductMapper implements RowMapper {

			@Override
			public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
				Product p = new Product();
				p.setPid(rs.getInt("pid"));
				p.setPprice(rs.getInt("pprice"));
				p.setPname(rs.getString("pname"));
				p.setPreview(rs.getString("preview"));
				return p;
			}
		}
		try {
			final String query = "select * from detail where pid=?";
			Product p = (Product) jdbcTemplate.queryForObject(query, new ProductMapper(), new Object[] { id });
			return p;
		} catch (Exception e) {
			return null;
		}

	}

	// get Product like Name
	public List<Product> getproductlikeName(String name) {
		class ProductMapper implements RowMapper {

			@Override
			public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
				Product p = new Product();
				p.setPid(rs.getInt("pid"));
				p.setPprice(rs.getInt("pprice"));
				p.setPname(rs.getString("pname"));
				p.setPreview(rs.getString("preview"));
				return p;
			}

		}
		try {
			final String query = "select * from detail where pname like ?";
			List<Product> p = jdbcTemplate.query(query, new ProductMapper(), new Object[] { "%"+name+"%" });
			return p;

		} catch (Exception e) {
			return null;
		}
	}

	// to delete product
	public String deleteproduct(int id) {
		try {
			String query = "delete  from detail where pid=?";
			int x = jdbcTemplate.update(query, new Object[] {id});

			if (x != 0)
				return "success";
			else
				return "failed";

		} catch (Exception e) {
			e.printStackTrace();
			return "failed";
		}
	}
	// to update a product

	public String updateproduct(String name, Product p) {
		try {
			String query = "update detail set pid=?, pprice=?, pname=?, preview=? where pname=?";
			int x = jdbcTemplate.update(query,new Object[] { p.getPid(), p.getPprice(), p.getPname(), p.getPreview(), name });
			if (x != 0)
				return "success";
			else
				return "failed";

		} catch (Exception e) {
			e.printStackTrace();
			return "failed";
		}
	}

	// getAllproduct's name
	public List<String> getallproductsname() {

		class ProductMapper implements RowMapper {

			@Override
			public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
//				Product p = new Product();
//				p.setPid(rs.getInt("pid"));
//				return p;

				return rs.getString("pname");
			}

		}
		final String query = "select * from detail";
		List<String> pname = jdbcTemplate.query(query, new ProductMapper());
		return pname;

	}

	 // getAllproduct's ID
	public List<Integer> getallproductsId() {

		class ProductMapper implements RowMapper {

			@Override
			public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
//				Product p = new Product();
//				p.setPid(rs.getInt("pid"));
//				return p;

				return rs.getInt("pid");
			}

		}
		final String query = "select * from detail";
		List<Integer> pid = jdbcTemplate.query(query, new ProductMapper());
		return pid;

	}
	// to update a product

		public String updateproductbyId(Product p) {
			try {
				String query = "update detail set pprice=?, pname=?, preview=? where pid=?";
				int x = jdbcTemplate.update(query,new Object[] { p.getPprice(), p.getPname(), p.getPreview(), p.getPid()});
				if (x != 0)
					return "success";
				else
					return "failed";

			} catch (Exception e) {
				e.printStackTrace();
				return "failed";
			}
		}
		
		// get image
		public byte [] getimage(int pid) {
			class ProductMapper implements RowMapper{

				@Override
				public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
					
					return rs.getBytes("image");
				}
				
			}
			try {
				  final String query="select image from detail where pid=?";
				  byte [] b=(byte [])jdbcTemplate.queryForObject(query, new ProductMapper(), new Object[] {pid});
				  if(b!=null) {
					  return b;
				  }else {
					  return null;
				  }
			} catch (Exception e) {
				e.printStackTrace();
				return null;
			}
			
		}
}
