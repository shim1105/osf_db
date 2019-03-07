package osf.food.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import osf.food.dao.FoodDAO;
import osf.food.db.DBCon;
import osf.food.vo.FoodVO;

public class FoodDAOImpl implements FoodDAO {
	@Override
	public List<FoodVO> selectFoodList() {
		// TODO Auto-generated method stub
		String sql= "select food_num,food_name,food_price from food";
		try {
			PreparedStatement ps = DBCon.getCon().prepareStatement(sql);
			ResultSet rs= ps.executeQuery();
			List<FoodVO> foodList= new ArrayList<>();
			while(rs.next()) {
				FoodVO fv= new FoodVO();
				fv.setFoodNum(rs.getInt("food_num"));
				fv.setFoodName(rs.getString("food_name"));
				fv.setFoodPrice(rs.getInt("food_price"));
				foodList.add(fv);
			}
			return foodList;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBCon.close();
		}
		return null;
	}
	
	public static void main(String[] args) {
		FoodDAO  fd= new FoodDAOImpl();
		List<FoodVO> foodList=fd.selectFoodList();
		System.out.println(foodList);

	}

}
