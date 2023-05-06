select customers.id as customer_id, concat(name, ' ', surmane) as customer, product_name
from customers.customers
         join customers.orders on customers.id = orders.customer_id
where name ilike :name;