<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- Navigation -->
<aside id="menu">
    <div id="navigation">
        <div class="profile-picture">
            <a href="javascript:void(0)">
                <img style="width: 150px" src="${pageContext.request.contextPath}/resources/admin/images/logo.gif" class="img-circle m-b" alt="logo">
            </a>
        </div>
        <ul class="nav" id="side-menu">
            <li id="leftMenuProduct">
                <a href="javascript:void(0)"><span class="nav-label">商品管理</span><span class="fa arrow"></span> </a>
                <ul class="nav nav-second-level">
                    <li><a href="${pageContext.request.contextPath}/admin/productCategoryList">商品分类管理</a></li>
                    <li><a href="${pageContext.request.contextPath}/admin/productList">商品详情管理</a></li>
                    <li><a href="${pageContext.request.contextPath}/admin/optionInfo">商品规格管理</a></li>
                    <!-- <li><a href="#">商品品牌管理</a></li> -->
                    <li><a href="${pageContext.request.contextPath}/admin/comments">商品评论管理</a></li>
                </ul>
            </li>
            <li id="leftMenuOrder">
                <a href="javascript:void(0)"><span class="nav-label">订单管理</span><span class="fa arrow"></span></a>
                <ul class="nav nav-second-level">
                    <li><a href="${pageContext.request.contextPath}/order/select">订单详情管理</a></li>
                    <li><a href="${pageContext.request.contextPath}/admin/order/date">订单报表管理</a></li>
                    <li><a href="#">物流配送管理</a></li>
                </ul>
            </li>
            <li id="leftMenuUser">
                <a href="javascript:void(0)"><span class="nav-label">用户管理</span></a>
                <ul class="nav nav-second-level">
                <li><a href="${pageContext.request.contextPath}/admin/user">用户详情管理</a></li>
                 <!-- <li><a href="#">VIP管理</a></li> -->
                </ul>
            </li>
            <li id="leftMenuArticle">
                <a href="javascript:void(0)"><span class="nav-label">公告管理</span><span class="fa arrow"></span> </a>
                <ul class="nav nav-second-level">
                    <li><a href="${pageContext.request.contextPath}/admin/articlecategory">公告分类管理</a></li>
                    <li><a href="${pageContext.request.contextPath}/admin/article">公告详情管理</a></li>
                </ul>
            </li>
            <li>
                <a href="${pageContext.request.contextPath}/admin/eWallet"><span class="nav-label">电子钱包初始金额设定</span></a>
            </li>
             <li>
                <a href="${pageContext.request.contextPath}/admin/advert"><span class="nav-label">广告管理</span></a>
            </li>
            <li id="LeftMenuNote">
             <a href="javascript:void(0)"><span class="nav-label">动态管理</span></a>
              <ul class="nav nav-second-level">
                <li><a href="${pageContext.request.contextPath}/admin/note">动态详情管理</a></li>
                <li><a href="javascript:void(0)">动态标签管理</a></li>
                <li><a href="javascript:void(0)">动态评论管理</a></li>
              </ul>
            </li> 
        </ul>
    </div>
</aside>