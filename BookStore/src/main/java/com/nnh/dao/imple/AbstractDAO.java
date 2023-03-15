package com.nnh.dao.imple;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import com.nnh.dao.itf.GenericDAO;
import com.nnh.mapper.RowMapper;
import com.nnh.model.BookModel;

public class AbstractDAO<T> implements GenericDAO<T>{
	
	ResourceBundle rb = ResourceBundle.getBundle("db");
	
	public Connection getCNT() {
		Connection c = null;
		try {
			Class.forName(rb.getString("driver"));
			String url = rb.getString("url");
			String username = rb.getString("username");
			String password = rb.getString("password");
			
			try {
				return DriverManager.getConnection(url, username, password);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	
	public void setParameter(PreparedStatement ps, Object...objects) {
		if(objects != null) {
			try {
				for(int i = 0; i < objects.length; i++) {
					Object parameter = objects[i];
					int index = i + 1;
					if(parameter instanceof Long) {
						ps.setLong(index,(Long) parameter);
					}else if(parameter instanceof Integer) {
						ps.setInt(index,(Integer) parameter);
					}else if(parameter instanceof String) {
						ps.setString(index, (String) parameter);
					}else if(parameter instanceof Timestamp) {
						ps.setTimestamp(index, (Timestamp) parameter);
					}else if(parameter == null) {
						ps.setNull(index, Types.NULL);
					}
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public List<T> find(String sql, RowMapper<T> rowMapper, Object...object) {
		List<T> lt = new ArrayList<>();
		Connection c = getCNT();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = c.prepareStatement(sql);
			setParameter(ps, object);
			rs = ps.executeQuery();
			while(rs.next()) {
				lt.add(rowMapper.rowMapper(rs));
			}
			
			return lt;
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			try {
				if(c != null) {
					c.close();
				}
				if(ps != null) {
					ps.close();
				}
				if(rs != null) {
					rs.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return null;
	}

	@Override
	public Long insert(String sql, Object...objects) {
		Long id = null;
		Connection c = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			c = getCNT();
			c.setAutoCommit(false);
			ps = c.prepareStatement(sql, ps.RETURN_GENERATED_KEYS);
			setParameter(ps, objects);
			ps.executeUpdate();
			rs = ps.getGeneratedKeys();
			while(rs.next()) {
				id = rs.getLong(1);
			}
			c.commit();
			
			return id;
		} catch (SQLException e) {
			if(c != null) {
				try {
					c.rollback();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
			e.printStackTrace();
		} finally {
			try {
				if(c != null) {
					c.close();
				}
				if(ps != null) {
					ps.close();
				}
				if(rs != null) {
					rs.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return null;
	}

	@Override
	public void update(String sql, Object... objects) {
		Connection c = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			c = getCNT();
			c.setAutoCommit(false);
			ps = c.prepareStatement(sql);
			setParameter(ps, objects);
			ps.executeUpdate();
			c.commit();
		} catch (SQLException e) {
			if(c != null) {
				try {
					c.rollback();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
			e.printStackTrace();
		} finally {
			try {
				if(c != null) {
					c.close();
				}
				if(ps != null) {
					ps.close();
				}
				if(rs != null) {
					rs.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	@Override
	public void delete(String sql, Object... objects) {
		Connection c = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			c = getCNT();
			c.setAutoCommit(false);
			ps = c.prepareStatement(sql);
			setParameter(ps, objects);
			ps.executeUpdate();
			c.commit();
		} catch (SQLException e) {
			if(c != null) {
				try {
					c.rollback();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
			e.printStackTrace();
		} finally {
			try {
				if(c != null) {
					c.close();
				}
				if(ps != null) {
					ps.close();
				}
				if(rs != null) {
					rs.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
}
