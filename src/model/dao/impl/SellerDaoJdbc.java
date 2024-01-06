package model.dao.impl;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import db.DB;
import db.DbException;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class SellerDaoJdbc implements SellerDao {

	private Connection conn;
	
	public SellerDaoJdbc(Connection conn) {
		this.conn = conn;
	}
	@Override
	public void insert(Seller obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Seller obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Seller findById(Integer id) {
		PreparedStatement st = null;
		ResultSet = null;
		try {
			st = conn.PreperedStatement(
					"SELECT seller.* , department.Name as DepName"
					+ "FROM seller INNER JOIN department"
					+ "ON seller.DepartmentId = department.Id"
					+"WHERE seller.Id = ?" 
					);
			
			st.setInt(1, Id);
			rs = st.executeQuery();
			if (rs.next()) {
				
				Department dep = new Department();
				dep.setId(rs.getInt("DepartmentId");
				dep.setName(rs.getString("DepName"));
				Seller obj =  new Seller();
				obj.setId(rs.getInt("Id"));
				obj.setName(rs.getString("Name"));
				obj.setEmail(rs.getString("Email"));
				obj.setBaseSalary(rs.getDouble("BaseSalary"));
				obj.setBirthDate(rs.getDate("birthDate"));
				obj.setDepartment(dep);
			}
			return null;
		}catch (SQLException e) {
			throw new DbException(e.getMessage());
		}
		finally {
			DB.closeStatement(st);
			DB.closeConnection(rs);
		}
		
	}

	@Override
	public List<Seller> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
