<%@ page import="java.util.ArrayList" %>
<%@ page import="com.example.library.beans.Book" %>
<!DOCTYPE html>

<html lang="en"><head><meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

    <title>page1</title>
    <link rel="stylesheet" href="../resources/css/normalize.min.css">
    <link rel="stylesheet" href="../resources/css/style.css">

</head>
<body>
<!-- partial:index.partial.html -->
<div class="app-container">
    <div class="sidebar">

        <ul class="sidebar-list">
            <li class="sidebar-list-item">
                <a href="/profile">
                    <span>My profile</span>
                </a>
            </li>
            <li class="sidebar-list-item">
                <a href="/bookbrowser">
                    <span>Books</span>
                </a>
            </li>
            <li class="sidebar-list-item active">
                <a href="/Order">
                    <span>Order</span>
                </a>
            </li>
            <li class="sidebar-list-item">
                <a href="/About">
                    <span>About</span>
                </a>
            </li>
            <li class="sidebar-list-item" >
                <a href="login">
                    <span style="font-size: 15.5px; ">Log Out</span>
                </a>
            </li>

        </ul>
        <div class="account-info">
            <div class="account-info-picture">
                <img src="./4html_files/1.png" alt="Account">
            </div>
            <div class="account-info-name">${student.name}</div>

        </div>
    </div>
    <div class="app-content">
        <div class="app-content-header">
            <h1 class="app-content-headerText">My Books</h1>
            <button class="mode-switch" title="Switch Theme">
                <svg class="moon" fill="none" stroke="currentColor" stroke-linecap="round" stroke-linejoin="round" stroke-width="2" width="24" height="24" viewBox="0 0 24 24">
                    <defs></defs>
                    <path d="M21 12.79A9 9 0 1111.21 3 7 7 0 0021 12.79z"></path>
                </svg>
            </button>

        </div>
        <div class="app-content-actions">

            <div class="app-content-actions-wrapper">





                <button class="action-button list active" title="List View">
                    <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="feather feather-list"><line x1="8" y1="6" x2="21" y2="6"></line><line x1="8" y1="12" x2="21" y2="12"></line><line x1="8" y1="18" x2="21" y2="18"></line><line x1="3" y1="6" x2="3.01" y2="6"></line><line x1="3" y1="12" x2="3.01" y2="12"></line><line x1="3" y1="18" x2="3.01" y2="18"></line></svg>
                </button>
                <button class="action-button grid" title="Grid View">
                    <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="feather feather-grid"><rect x="3" y="3" width="7" height="7"></rect><rect x="14" y="3" width="7" height="7"></rect><rect x="14" y="14" width="7" height="7"></rect><rect x="3" y="14" width="7" height="7"></rect></svg>
                </button>
            </div>
        </div>
        <div class="products-area-wrapper tableView">
            <div class="products-header">
                <div class="product-cell image">
                    Books
                    <button class="sort-button">
                        <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" viewBox="0 0 512 512"><path fill="currentColor" d="M496.1 138.3L375.7 17.9c-7.9-7.9-20.6-7.9-28.5 0L226.9 138.3c-7.9 7.9-7.9 20.6 0 28.5 7.9 7.9 20.6 7.9 28.5 0l85.7-85.7v352.8c0 11.3 9.1 20.4 20.4 20.4 11.3 0 20.4-9.1 20.4-20.4V81.1l85.7 85.7c7.9 7.9 20.6 7.9 28.5 0 7.9-7.8 7.9-20.6 0-28.5zM287.1 347.2c-7.9-7.9-20.6-7.9-28.5 0l-85.7 85.7V80.1c0-11.3-9.1-20.4-20.4-20.4-11.3 0-20.4 9.1-20.4 20.4v352.8l-85.7-85.7c-7.9-7.9-20.6-7.9-28.5 0-7.9 7.9-7.9 20.6 0 28.5l120.4 120.4c7.9 7.9 20.6 7.9 28.5 0l120.4-120.4c7.8-7.9 7.8-20.7-.1-28.5z"></path></svg>
                    </button>
                </div>
                <div class="product-cell category">Descipline<button class="sort-button">
                    <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" viewBox="0 0 512 512"><path fill="currentColor" d="M496.1 138.3L375.7 17.9c-7.9-7.9-20.6-7.9-28.5 0L226.9 138.3c-7.9 7.9-7.9 20.6 0 28.5 7.9 7.9 20.6 7.9 28.5 0l85.7-85.7v352.8c0 11.3 9.1 20.4 20.4 20.4 11.3 0 20.4-9.1 20.4-20.4V81.1l85.7 85.7c7.9 7.9 20.6 7.9 28.5 0 7.9-7.8 7.9-20.6 0-28.5zM287.1 347.2c-7.9-7.9-20.6-7.9-28.5 0l-85.7 85.7V80.1c0-11.3-9.1-20.4-20.4-20.4-11.3 0-20.4 9.1-20.4 20.4v352.8l-85.7-85.7c-7.9-7.9-20.6-7.9-28.5 0-7.9 7.9-7.9 20.6 0 28.5l120.4 120.4c7.9 7.9 20.6 7.9 28.5 0l120.4-120.4c7.8-7.9 7.8-20.7-.1-28.5z"></path></svg>
                </button></div>
                <div class="product-cell status-cell">Return date<button class="sort-button">
                    <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" viewBox="0 0 512 512"><path fill="currentColor" d="M496.1 138.3L375.7 17.9c-7.9-7.9-20.6-7.9-28.5 0L226.9 138.3c-7.9 7.9-7.9 20.6 0 28.5 7.9 7.9 20.6 7.9 28.5 0l85.7-85.7v352.8c0 11.3 9.1 20.4 20.4 20.4 11.3 0 20.4-9.1 20.4-20.4V81.1l85.7 85.7c7.9 7.9 20.6 7.9 28.5 0 7.9-7.8 7.9-20.6 0-28.5zM287.1 347.2c-7.9-7.9-20.6-7.9-28.5 0l-85.7 85.7V80.1c0-11.3-9.1-20.4-20.4-20.4-11.3 0-20.4 9.1-20.4 20.4v352.8l-85.7-85.7c-7.9-7.9-20.6-7.9-28.5 0-7.9 7.9-7.9 20.6 0 28.5l120.4 120.4c7.9 7.9 20.6 7.9 28.5 0l120.4-120.4c7.8-7.9 7.8-20.7-.1-28.5z"></path></svg>
                </button></div>
                <div class="product-cell sales">Author<button class="sort-button">
                    <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" viewBox="0 0 512 512"><path fill="currentColor" d="M496.1 138.3L375.7 17.9c-7.9-7.9-20.6-7.9-28.5 0L226.9 138.3c-7.9 7.9-7.9 20.6 0 28.5 7.9 7.9 20.6 7.9 28.5 0l85.7-85.7v352.8c0 11.3 9.1 20.4 20.4 20.4 11.3 0 20.4-9.1 20.4-20.4V81.1l85.7 85.7c7.9 7.9 20.6 7.9 28.5 0 7.9-7.8 7.9-20.6 0-28.5zM287.1 347.2c-7.9-7.9-20.6-7.9-28.5 0l-85.7 85.7V80.1c0-11.3-9.1-20.4-20.4-20.4-11.3 0-20.4 9.1-20.4 20.4v352.8l-85.7-85.7c-7.9-7.9-20.6-7.9-28.5 0-7.9 7.9-7.9 20.6 0 28.5l120.4 120.4c7.9 7.9 20.6 7.9 28.5 0l120.4-120.4c7.8-7.9 7.8-20.7-.1-28.5z"></path></svg>
                </button></div>
                <div class="product-cell stock">Stock<button class="sort-button">
                    <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" viewBox="0 0 512 512"><path fill="currentColor" d="M496.1 138.3L375.7 17.9c-7.9-7.9-20.6-7.9-28.5 0L226.9 138.3c-7.9 7.9-7.9 20.6 0 28.5 7.9 7.9 20.6 7.9 28.5 0l85.7-85.7v352.8c0 11.3 9.1 20.4 20.4 20.4 11.3 0 20.4-9.1 20.4-20.4V81.1l85.7 85.7c7.9 7.9 20.6 7.9 28.5 0 7.9-7.8 7.9-20.6 0-28.5zM287.1 347.2c-7.9-7.9-20.6-7.9-28.5 0l-85.7 85.7V80.1c0-11.3-9.1-20.4-20.4-20.4-11.3 0-20.4 9.1-20.4 20.4v352.8l-85.7-85.7c-7.9-7.9-20.6-7.9-28.5 0-7.9 7.9-7.9 20.6 0 28.5l120.4 120.4c7.9 7.9 20.6 7.9 28.5 0l120.4-120.4c7.8-7.9 7.8-20.7-.1-28.5z"></path></svg>
                </button></div>
                <div class="product-cell price">Topic<button class="sort-button">
                    <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" viewBox="0 0 512 512"><path fill="currentColor" d="M496.1 138.3L375.7 17.9c-7.9-7.9-20.6-7.9-28.5 0L226.9 138.3c-7.9 7.9-7.9 20.6 0 28.5 7.9 7.9 20.6 7.9 28.5 0l85.7-85.7v352.8c0 11.3 9.1 20.4 20.4 20.4 11.3 0 20.4-9.1 20.4-20.4V81.1l85.7 85.7c7.9 7.9 20.6 7.9 28.5 0 7.9-7.8 7.9-20.6 0-28.5zM287.1 347.2c-7.9-7.9-20.6-7.9-28.5 0l-85.7 85.7V80.1c0-11.3-9.1-20.4-20.4-20.4-11.3 0-20.4 9.1-20.4 20.4v352.8l-85.7-85.7c-7.9-7.9-20.6-7.9-28.5 0-7.9 7.9-7.9 20.6 0 28.5l120.4 120.4c7.9 7.9 20.6 7.9 28.5 0l120.4-120.4c7.8-7.9 7.8-20.7-.1-28.5z"></path></svg>
                </button></div>

            </div>
            <% int i=0; %>
            <c:forEach  items="${books}" var="val" >
                <div class="products-row">
                    <button class="cell-more-button">
                        <svg xmlns="http://www.w3.org/2000/svg" width="18" height="18" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="feather feather-more-vertical"><circle cx="12" cy="12" r="1"></circle><circle cx="12" cy="5" r="1"></circle><circle cx="12" cy="19" r="1"></circle></svg>
                    </button>
                    <div class="product-cell image">
                        <img src="${val.imgurl}" alt="product">
                        <span>${val.title}</span>
                    </div>
                    <div class="product-cell category"><span class="cell-label">Category:</span>${val.category}</div>
                    <div class="product-cell status-cell">
                        <span class="cell-label">Status:</span>
                            ${val.getReturnDate(student.studentId)}



<%--                                <span class="status disabled"><jsp:useBean id="test" class="com.example.library.beans.Book"> ${test.getReturnDate(student.StudentId)}</span>--%>

                    </div>
                    <% i++; %>
                    <div class="product-cell sales"><span class="cell-label">Sales:</span>${val.author}</div>
                    <div class="product-cell stock"><span class="cell-label">Stock:</span>${val.nbavailable}</div>
                    <div class="product-cell price"><span class="cell-label">Price:</span>${val.category}</div>

                </div>
            </c:forEach>

<%--            <div class="products-row">--%>
<%--                <button class="cell-more-button">--%>
<%--                    <svg xmlns="http://www.w3.org/2000/svg" width="18" height="18" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="feather feather-more-vertical"><circle cx="12" cy="12" r="1"></circle><circle cx="12" cy="5" r="1"></circle><circle cx="12" cy="19" r="1"></circle></svg>--%>
<%--                </button>--%>
<%--                <div class="product-cell image">--%>
<%--                    <img src="data:image/png;base64,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" alt="product">--%>
<%--                    <span>Calculus</span>--%>
<%--                </div>--%>
<%--                <div class="product-cell category"><span class="cell-label">Category:</span>Maths</div>--%>
<%--                <div class="product-cell status-cell">--%>
<%--                    <span class="cell-label">Status:</span>--%>
<%--                    <span class="status disabled">unavailable</span>--%>
<%--                </div>--%>
<%--                <div class="product-cell sales"><span class="cell-label">Sales:</span>Michel Showmaker</div>--%>
<%--                <div class="product-cell stock"><span class="cell-label">Stock:</span>0</div>--%>
<%--                <div class="product-cell price"><span class="cell-label">Price:</span>Calculus 1</div>--%>

<%--            </div>--%>
<%--            <div class="products-row">--%>
<%--                <button class="cell-more-button">--%>
<%--                    <svg xmlns="http://www.w3.org/2000/svg" width="18" height="18" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="feather feather-more-vertical"><circle cx="12" cy="12" r="1"></circle><circle cx="12" cy="5" r="1"></circle><circle cx="12" cy="19" r="1"></circle></svg>--%>
<%--                </button>--%>
<%--                <div class="product-cell image">--%>
<%--                    <img src="./4html_files/saved_resource" alt="product">--%>
<%--                    <span>Data Science</span>--%>
<%--                </div>--%>
<%--                <div class="product-cell category"><span class="cell-label">Category:</span>computer science</div>--%>
<%--                <div class="product-cell status-cell">--%>
<%--                    <span class="cell-label">Status:</span>--%>
<%--                    <span class="status active">Available</span>--%>
<%--                </div>--%>
<%--                <div class="product-cell sales"><span class="cell-label">Sales:</span>Thomas Crimson</div>--%>
<%--                <div class="product-cell stock"><span class="cell-label">Stock:</span>15</div>--%>
<%--                <div class="product-cell price"><span class="cell-label">Price:</span>Big Data</div>--%>
<%--            </div>--%>
<%--            <div class="products-row">--%>
<%--                <button class="cell-more-button">--%>
<%--                    <svg xmlns="http://www.w3.org/2000/svg" width="18" height="18" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="feather feather-more-vertical"><circle cx="12" cy="12" r="1"></circle><circle cx="12" cy="5" r="1"></circle><circle cx="12" cy="19" r="1"></circle></svg>--%>
<%--                </button>--%>
<%--                <div class="product-cell image">--%>
<%--                    <img src="data:image/png;base64,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" alt="product">--%>
<%--                    <span>Calculus</span>--%>
<%--                </div>--%>
<%--                <div class="product-cell category"><span class="cell-label">Category:</span>Maths</div>--%>
<%--                <div class="product-cell status-cell">--%>
<%--                    <span class="cell-label">Status:</span>--%>
<%--                    <span class="status disabled">Not available</span>--%>
<%--                </div>--%>
<%--                <div class="product-cell sales"><span class="cell-label">Sales:</span>Michel Showmaker</div>--%>
<%--                <div class="product-cell stock"><span class="cell-label">Stock:</span>0</div>--%>
<%--                <div class="product-cell price"><span class="cell-label">Price:</span>Calculus 1</div>--%>

<%--            </div>   <div class="products-row">--%>
<%--            <button class="cell-more-button">--%>
<%--                <svg xmlns="http://www.w3.org/2000/svg" width="18" height="18" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="feather feather-more-vertical"><circle cx="12" cy="12" r="1"></circle><circle cx="12" cy="5" r="1"></circle><circle cx="12" cy="19" r="1"></circle></svg>--%>
<%--            </button>--%>
<%--            <div class="product-cell image">--%>
<%--                <img src="./4html_files/saved_resource" alt="product">--%>
<%--                <span>Data Science</span>--%>
<%--            </div>--%>
<%--            <div class="product-cell category"><span class="cell-label">Category:</span>computer science</div>--%>
<%--            <div class="product-cell status-cell">--%>
<%--                <span class="cell-label">Status:</span>--%>
<%--                <span class="status active">Available</span>--%>
<%--            </div>--%>
<%--            <div class="product-cell sales"><span class="cell-label">Sales:</span>Thomas Crimson</div>--%>
<%--            <div class="product-cell stock"><span class="cell-label">Stock:</span>15</div>--%>
<%--            <div class="product-cell price"><span class="cell-label">Price:</span>Big Data</div>--%>









        </div>
    </div>
</div>
<script src="../resources/javascript/script.js"></script>



</body></html>