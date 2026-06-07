package com.example.demo.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.demo.config.DataSourceConfiguration;
import com.example.demo.model.Shohin;

@Repository
public class ShohinDAO 
{
    @Autowired
    JdbcTemplate jdbcTemplate;

    DataSourceConfiguration dsc;

    public List<Shohin> selectShohin() throws DataAccessException
    {
    	// SQL文を作成
        String sql = "select * from shohin";

        dsc = new DataSourceConfiguration();
        jdbcTemplate = dsc.jdbcTemplate();

		// queryForListメソッドでSQLを実行し、結果MapのListで受け取る。
        List<Map<String, Object>> shohins = jdbcTemplate.queryForList(sql);
        
        // Shohinオブジェクト格納用のListを作成する。
        List<Shohin> shohinList = new ArrayList<Shohin>();
        
        // 受け取ったMapのListをfor文で回し、各ユーザの値をShohinオブジェクトに格納する。
        for(Map<String, Object> eachShohin: shohins)
        {
        	Shohin shohin = new Shohin();
        	shohin.setShohinID((Integer)(eachShohin.get("shohin_id")));
        	if (eachShohin.get("shohin_name") != null)
        	{
        	    shohin.setShohinName((String)(eachShohin.get("shohin_name")));
        	}
        	if (eachShohin.get("category") != null)
        	{
        	    shohin.setCategory((String)(eachShohin.get("category")));
        	}
        	if (eachShohin.get("shiire_tanka") != null)
        	{
        		shohin.setShireTanka((Integer)(eachShohin.get("shiire_tanka")));
        	}
        	if (eachShohin.get("hanbai_tanka") != null)
        	{
        		shohin.setHanbaiTanka((Integer)(eachShohin.get("hanbai_tanka")));
        	}
           // ShohinオブジェクトをListに追加する。
        	shohinList.add(shohin);
        }
        // 追加されたListオブジェクトを返却
        return shohinList;
    }

    public List<Shohin> selectShohin(String keyword) throws DataAccessException
    {
    	// SQL文を作成
        String sql = "";
 
        dsc = new DataSourceConfiguration();
        jdbcTemplate = dsc.jdbcTemplate();
 
        // StringBUfferクラスのインスタンスの生成
        StringBuffer sb = new StringBuffer();
        // 文字列追加処理「
        sb.append("SELECT shohin_id, shohin_name, category, shiire_tanka, hanbai_tanka");
        sb.append(" ");
        sb.append("FROM SHOHIN");
        sb.append(" ");
        sb.append("WHERE");
        sb.append(" ");
        sb.append("shohin_name LIKE \"%" + keyword + "%\" OR  ");
        sb.append("category LIKE \"%" + keyword + "%\" OR   ");
        sb.append("shiire_tanka LIKE \"%" + keyword + "%\" OR   ");
        sb.append("hanbai_tanka LIKE \"%" + keyword + "%\"");
        // 文字列変換
        sql = sb.toString();

		// queryForListメソッドでSQLを実行し、結果MapのListで受け取る。
        List<Map<String, Object>> shohins = jdbcTemplate.queryForList(sql);
        
        // Shohinオブジェクト格納用のListを作成する。
        List<Shohin> shohinList = new ArrayList<Shohin>();
        
        // 受け取ったMapのListをfor文で回し、各ユーザの値をShohinオブジェクトに格納する。
        for(Map<String, Object> eachShohin: shohins)
        {
        	Shohin shohin = new Shohin();
        	shohin.setShohinID((Integer)(eachShohin.get("shohin_id")));
        	if (eachShohin.get("shohin_name") != null)
        	{
        	    shohin.setShohinName((String)(eachShohin.get("shohin_name")));
        	}
        	if (eachShohin.get("category") != null)
        	{
        	    shohin.setCategory((String)(eachShohin.get("category")));
        	}
        	if (eachShohin.get("shiire_tanka") != null)
        	{
        		shohin.setShireTanka((Integer)(eachShohin.get("shiire_tanka")));
        	}
        	if (eachShohin.get("hanbai_tanka") != null)
        	{
        		shohin.setHanbaiTanka((Integer)(eachShohin.get("hanbai_tanka")));
        	}
            // ShohinオブジェクトをListに追加する。
        	shohinList.add(shohin);
        }
        // 追加されたListオブジェクトを返却
        return shohinList;
    }
}
