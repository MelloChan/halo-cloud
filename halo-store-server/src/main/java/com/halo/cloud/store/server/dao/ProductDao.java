package com.halo.cloud.store.server.dao;


import com.halo.cloud.dto.ItemInfoDTO;
import com.halo.cloud.entity.Product;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author MelloChan
 * @date 2018/5/31
 */
@Mapper
public interface ProductDao {
    /**
     * 获取部分商品信息
     *
     * @return 商品信息列表
     */
    @Select("SELECT\n" +
            "            id,\n" +
            "            image,\n" +
            "            name,\n" +
            "            title,\n" +
            "            price\n" +
            "        FROM hl_product\n" +
            "        LIMIT #{pageIndex}, #{pageCount}")
    List<Product> getItems(@Param("pageIndex") Integer pageIndex, @Param("pageCount") Integer pageCount);

    /**
     * 通过分类id查询商品
     */
    @Select("SELECT\n" +
            "            id,\n" +
            "            image,\n" +
            "            name,\n" +
            "            title,\n" +
            "            price\n" +
            "        FROM hl_product\n" +
            "        WHERE cate_id = #{cateId}")
    List<Product> getItemsByCateId(@Param("cateId") Integer cateId);

    /**
     * 通过类型id查询商品
     */
    @Select("SELECT\n" +
            "            id,\n" +
            "            image,\n" +
            "            name,\n" +
            "            title,\n" +
            "            price\n" +
            "        FROM hl_product\n" +
            "        WHERE type_id = #{typeId}")
    List<Product> getItemsByTypeId(@Param("typeId") Integer typeId);

    /**
     * 通过品牌id查询商品
     */
    @Select("SELECT\n" +
            "            id,\n" +
            "            image,\n" +
            "            name,\n" +
            "            title,\n" +
            "            price\n" +
            "        FROM hl_product\n" +
            "        WHERE brand_id = #{brandId}")
    List<Product> getItemsByBrandId(@Param("brandId") Integer brandId);

    /**
     * 通过分类id与类型id查询
     */
    @Select("SELECT\n" +
            "            id,\n" +
            "            image,\n" +
            "            name,\n" +
            "            title,\n" +
            "            price\n" +
            "        FROM hl_product\n" +
            "        WHERE cate_id = #{cateId} AND type_id = #{typeId}")
    List<Product> getItemsByCateIdAndTypeId(@Param("cateId") Integer cateId, @Param("typeId") Integer typeId);

    /**
     * 通过分类di与品牌id查询
     */
    @Select("SELECT\n" +
            "            id,\n" +
            "            image,\n" +
            "            name,\n" +
            "            title,\n" +
            "            price\n" +
            "        FROM hl_product\n" +
            "        WHERE cate_id = #{cateId} AND brand_id = #{brandId}")
    List<Product> getItemsByCateIdAndBrandId(@Param("cateId") Integer cateId, @Param("brandId") Integer brandId);

    /**
     * 通过名字模糊查找商品
     */
    @Select("SELECT\n" +
            "            id,\n" +
            "            image,\n" +
            "            name,\n" +
            "            title,\n" +
            "            price\n" +
            "        FROM hl_product\n" +
            "        WHERE position(#{name} in name)")
    List<Product> searchItemByName(@Param("name") String name);

    /**
     * 减库存
     */
    @Update("UPDATE hl_product\n" +
            "        SET stock=stock-1\n" +
            "        WHERE id=#{proId} AND stock>0")
    Integer updateMinusStockByProId(@Param("proId") Integer proId);

    /**
     * 后台获取商品信息
     */
    @Select("SELECT\n" +
            "            hl_product.id,\n" +
            "            name,\n" +
            "            description,\n" +
            "            price,\n" +
            "            stock,\n" +
            "            type_name,\n" +
            "            hl_product.gmt_create,\n" +
            "            hl_product.gmt_updated\n" +
            "        FROM hl_product, hl_product_detail, hl_type\n" +
            "        WHERE hl_product.id=pro_id AND type_id=hl_type.id\n" +
            "        LIMIT #{pageIndex}, #{pageCount}")
    List<ItemInfoDTO> getItemsInfo(@Param("pageIndex") Integer pageIndex, @Param("pageCount") Integer pageCount);

    /**
     * 后台删除商品表中指定商品
     */
    @Delete("DELETE FROM hl_product\n" +
            "        WHERE id = #{id}")
    void deleteProductById(@Param("id") Integer id);

    /**
     * 后台删除指定商品的详细描述（图片）
     */
    @Delete("DELETE FROM hl_product_detail\n" +
            "        WHERE pro_id = #{id}")
    void deleteProductDetailById(@Param("id") Integer id);

    /**
     * 后台删除指定商品的图片
     */
    @Delete("DELETE FROM hl_product_image\n" +
            "        WHERE pro_id = #{id}")
    void deleteProductImageById(@Param("id") Integer id);

    /**
     * 后台删除指定商品的详细描述（文字）
     */
    @Delete("DELETE FROM hl_product_specification\n" +
            "        WHERE pro_id = #{id}")
    void deleteProductSpecificationById(@Param("id") Integer id);

    /**
     * 删除多个商品信息
     */
    @Delete("<SCRIPT>" +
            "DELETE FROM hl_product\n" +
            "        WHERE id IN\n" +
            "        <foreach collection=\"idList\" separator=\",\" open=\"(\" close=\")\" item=\"idItem\">\n" +
            "            #{idItem}\n" +
            "        </foreach>" +
            "</SCRIPT>")
    void deleteMultiProductsById(@Param("idList") List<Integer> idList);

    /**
     * 删除多个商品相应的详细描述（图片）
     */
    @Delete("<SCRIPT>" +
            "DELETE FROM hl_product_detail\n" +
            "        WHERE pro_id IN\n" +
            "        <foreach collection=\"idList\" separator=\",\" open=\"(\" close=\")\" item=\"idItem\">\n" +
            "            #{idItem}\n" +
            "        </foreach>" +
            "</SCRIPT>")
    void deleteMultiProductDetailsById(@Param("idList") List<Integer> idList);

    /**
     * 删除多个商品相应的图片
     */
    @Delete("<SCRIPT>" +
            "DELETE FROM hl_product_image\n" +
            "        WHERE pro_id IN\n" +
            "        <foreach collection=\"idList\" separator=\",\" open=\"(\" close=\")\" item=\"idItem\">\n" +
            "            #{idItem}\n" +
            "        </foreach>" +
            "</SCRIPT>")
    void deleteMultiProductImagesById(@Param("idList") List<Integer> idList);

    /**
     * 删除多个商品相应的详细描述（文字）
     */
    @Delete("<SCRIPT>" +
            "DELETE FROM hl_product_specification\n" +
            "        WHERE pro_id IN\n" +
            "        <foreach collection=\"idList\" separator=\",\" open=\"(\" close=\")\" item=\"idItem\">\n" +
            "            #{idItem}\n" +
            "        </foreach>" +
            "</SCRIPT>")
    void deleteMultiProductSpecificationById(@Param("idList") List<Integer> idList);

    /**
     * 更改商品信息
     */
    @Update("UPDATE hl_product\n" +
            "        SET name = #{name}, stock = stock + #{num}, price = #{price}, gmt_updated = now()\n" +
            "        WHERE id = #{id}")
    void updateProductInfoById(@Param("id") Integer id, @Param("name") String name, @Param("num") Integer num,
                               @Param("price") Integer price);

    /**
     * 获取商品库存
     */
    @Select("SELECT stock\n" +
            "        FROM hl_product\n" +
            "        WHERE id = #{id}")
    Integer getStockById(@Param("id") Integer id);

    /**
     * 通过类型和名字获取商品信息
     */
    @Select("<SCRIPT>" +
            "SELECT\n" +
            "            hl_product.id,\n" +
            "            name,\n" +
            "            description,\n" +
            "            price,\n" +
            "            stock,\n" +
            "            type_name,\n" +
            "            hl_product.gmt_create,\n" +
            "            hl_product.gmt_updated\n" +
            "        FROM hl_product, hl_product_detail, hl_type\n" +
            "        WHERE hl_product.id=pro_id AND type_id=hl_type.id AND position(#{type} IN type_name)\n" +
            "            <if test=\"name != null\">\n" +
            "                AND position(#{name} IN name)\n" +
            "            </if>\n" +
            "        LIMIT #{pageIndex}, #{pageCount}" +
            "</SCRIPT>")
    List<ItemInfoDTO> getItemsInfoByTypeAndName(@Param("type") String type, @Param("name") String name, @Param("pageIndex") Integer paeIndex,
                                                @Param("pageCount") Integer pageCount);

    /**
     * 获取无库存商品数
     */
    @Select("SELECT count(id) FROM hl_product WHERE stock = 0")
    Integer getNumOfZeroStock();

    /**
     * @return 获取数据库中商品数
     */
    @Select("SELECT count(id) FROM hl_product")
    Integer getNumOfProducts();
}
