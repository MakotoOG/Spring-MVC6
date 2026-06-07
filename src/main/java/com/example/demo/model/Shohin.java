package com.example.demo.model;


public class Shohin
{
    public int shohin_id;
    public String shohin_name;
    public String category;
    public int shiire_tanka;
    public int hanbai_tanka;
    
    public void setShohinID(int shohin_id)
    {
    	this.shohin_id = shohin_id;
    }

    public void setShohinName(String shohin_name)
    {
    	this.shohin_name = shohin_name;
    }

    public void setCategory(String category)
    {
    	this.category = category;
    }

    public void setShireTanka(int shiire_tanka)
    {
    	this.shiire_tanka = shiire_tanka;
    }

    public void setHanbaiTanka(int hanbai_tanka)
    {
    	this.hanbai_tanka = hanbai_tanka;
    }

    public int getShohinID()
    {
    	return shohin_id;
    }

    public String getShohinName()
    {
    	return shohin_name;
    }

    public String getCategory()
    {
    	return category;
    } 
 
    public int getShireTanka()
    {
    	return shiire_tanka;
    }

    public int getHanbaiTanka()
    {
    	return hanbai_tanka;
    }

}
