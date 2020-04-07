Largely based off this tutorial by Talk2 Amareswaran: https://www.youtube.com/watch?v=wxebTn_a930

A few changes...

Instead of MySQL, using H2

data.sql file provided to generate tables and insert test data. The queries differ slighly from Talk2 Amareswaran's because this program uses H2 instead of MySQL. Review that file for a note explaining why some values are true that would expect to be false, given the column and property names.

To generate a token:
1. open POSTMAN
2. http://localhost:9001/oauth/token for url, POST HTTP Method
3. Under Authorization tab, select Basic Auth
4. For Username enter USER_CLIENT_APP
5. For Password enter password
6. Click on Body tab
7. key name = grant_type, value = password
8. key name = username, value = test123
9. key name = password, value = password