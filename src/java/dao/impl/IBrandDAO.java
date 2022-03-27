/*
 * Copyright(C) 2021, group 3 SE1511JS
 * T.NET:
 *  Vehicle Store
 *
 * Record of change:
 * DATE            Version             AUTHOR           DESCRIPTION
 * 2021-02-09      1.0                 ThaiNV           Add Field
 */
package dao.impl;

import entity.Brand;
import java.util.List;
import java.util.Vector;

/**
 *
 * @author Thainv
 */
public interface IBrandDAO {

    /*
    take all brand ==>  will return a list of brand contain : brandID, brandName
     */
    public Vector<Brand> getAllBrand() throws Exception;

    public List<Brand> searchBrand(String brandName, String sort) throws Exception;

    public List<Brand> BrandPaging(List<Brand> list, int start, int end);

    public List<Brand> getBrandRequestList() throws Exception;

    public void acceptBrand(int brandId) throws Exception;

    public void deleteBrand(int brandId) throws Exception;

    public void updateBrand(int brandId) throws Exception;

    public void addBrand(String brandName, String description, String img) throws Exception;
}
