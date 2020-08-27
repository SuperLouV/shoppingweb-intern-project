# shoppingweb
This is a Spring Boot web for dropshyp **(prototype)**.
This Web designed to provide trading services. We provide website templates and goods so that users can build their web and then import goods from our databases.
After real buyers paying through payment API, the platform will give corresponding rebates to the sellers.

## Program logic and structure
### Front-end
1. User login and register on /resources/templates/login.html
2. Redirect to main page(index.html), user session need to be sent to page. Main page shows popular goods information and oher links, for example Twitter and Dropshyp blogs
3. list-view1.html(same as all-ad.html) shows all goods and allows user to view goods through selecting categroies. Now, this pages only access the categroies API used to show  categroies on the left of page.
4. cart.html is user shopping cart, user can select goods from list-view1.html and the add them into cart before importing to own shop.
5. store-detail.html can be used to as shop template, for now we only have one template.
6. single-product1.html and single-product2.html can be used to show goods details
7. Other pages include bolg, 404, about
### Back-end
#### Model
The Model layer corresponds to the entities in the database. After running, the database is automatically generated. If the changes in the code are not updated in the database, delete database and re-run the code
#### Dao
Import JpaRepository used as database operations
#### Service
1. AdminProductService：Save goods in admin system
2. CategoryService: Get category and return a List used to show and slected
3. LoginAndRegisterService: Register and login
4. ProductListService: Get suppliers used to show drop-down menu on /templates/admin/goodsManage/goods_add.html **(it can be merged to ProducService)**
5. ProducService: Product operation
6. UserService: Change and update user information
#### Controller
1. AdminProductController: Control goods operation
2. IndexController: Redirect to index.html
3. LoginAndRegisterController: Register and login
4. ProductController: Goods display operations
#### Utils
1. InputChecker: Check input
2. RedisUtil: Override Redis operations
#### errorHandler
Used to control error **(not be used)**
#### configuration
1. RedisConfig: Redis
2. SecurityConfig: Import Spring Security as filter 

### Datebase
https://dbdiagram.io/d/5f0f803274ca2227330d67c5
## Technologies

## Detailes
