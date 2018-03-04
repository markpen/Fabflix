# Fablix
Used DBMS technique building J2EE Web application.

## Overview
This project mainly used DBMS technique to build web-based application, and did some performance improvement. And at the end of the  developed an android application as a mobile platform of the website.
#### Back-end
Chose to use servlet to build a back-end service. Because it provides a way to generate the dynamic documents both easy to write and fast to run. And  chose tomcat as a servlet container. Because it is lightweight and open-source.  Deployed the instance on amazon web service. As for database,  Used MySQL and used JDBC to establish the connectivity between servlet and database. 
In the database, maintained 8 tables. One is for user which store users’ account information. It would be used in log in page. The other 7 stored movie information and star information, which provides the content of the website. In the database,  Use edit distance algorithm to provide fuzzy query.
In the servlets, Mainly created 3 servlets. The first one is log in page, every user should have his own account. Another is searching, the user can input some key words to find the results he wants. The third one is shopping cart. Users can add the movie they want into the shopping cart and then check out.
#### Front-end
Created 10 JSP pages. The first page is log in page, anyone wants to get in the shop must log in first. The second one is main page, it would show random search results, and it is the entrance for other pages. For searching, used three pages, one for simple searching, one for advance searching, and the last one would show the results of the search. In advance searching, provided different key values, such like name, year, stars in the movie and directors. Next page is cart page, which shows the movies that had been added in the cart by customers. Other pages were status pages, showing the results of some operations such like successfully log in or fail to log in, successfully check out. 
#### Mobile platform
Developed a mobile platform for the website. It was a very simple application, only contained 3 views, one for login, one for simple searching, the other for showing the results of searching. 
#### Scalable
To make my application scalable, did some performance improvements. Used connect pooling to eliminate the cost to establish the connections between the servlets and database. Used a frontend load balancer to deal with huge requests. In this structure, I would use 5 instances. The first instance is a load balancer. Used apache2 as the balancer web server. The balancer would send requests to back-end randomly. For 4 back-ends, set one of them as a master and others slaves. To keep the databases in two instances have the consistent data, only do the operations on master instance and the slave would read the log of master and executed it. 
