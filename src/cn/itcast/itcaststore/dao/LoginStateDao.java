package cn.itcast.itcaststore.dao;
import java.sql.SQLException;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import cn.itcast.itcaststore.domain.LoginState;
import cn.itcast.itcaststore.utils.DataSourceUtils;

public class LoginStateDao {
	//添加登录时间
	public void addLogin(LoginState loginstate, int id) throws SQLException {
		String sql = "insert into login_time(user_id,login_time) values(?,?)";
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		int row = runner.update(sql, id, loginstate.getLoginTime());
		if (row == 0) {
			throw new RuntimeException();
		}
	}
	public void addLogout(LoginState loginstate, int id) throws SQLException {
		String sql = "update login_time set logout_time=? where user_id=? "+
				"ORDER BY login_time  LIMIT 1";
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		runner.update(sql, loginstate.getLogoutTime(), id);
	}
}
