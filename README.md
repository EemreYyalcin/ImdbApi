# ImdbApi

**Get Token With Postman**

-> Post Url: 127.0.0.1:8080/oauth/token

-> Authorization -> Basic Auth -> Username and Password must be clientId and clientSecret

-> Body -> form-data -> grant_type:password,username:user_name, password:passwordx

-> Headers -> Content-Type:application/x-www-form-urlencoded

**Example Curl Link**

curl -X POST \
  http://127.0.0.1:8080/oauth/token \
  -H 'Accept: */*' \
  -H 'Accept-Encoding: gzip, deflate' \
  -H 'Authorization: Basic dGVzdEltZGJDbGllbnRJZDppbWRiLXRlc3Qtc2VjcmV0LWtleQ==' \
  -H 'Cache-Control: no-cache' \
  -H 'Connection: keep-alive' \
  -H 'Content-Length: 404' \
  -H 'Content-Type: application/x-www-form-urlencoded' \
  -H 'Host: 127.0.0.1:8080' \
  -H 'User-Agent: PostmanRuntime/7.16.3' \
  -H 'cache-control: no-cache' \
  -H 'content-type: multipart/form-data; boundary=----WebKitFormBoundary7MA4YWxkTrZu0gW' \
  -F grant_type=password \
  -F username=exxxxx \
  -F password=eyyyyy


**Get Refresh Token**

-> Post Url: 127.0.0.1:8080/oauth/token

-> Authorization -> Basic Auth -> Username and Password must be clientId and clientSecret

-> Body -> form-data -> grant_type:refresh_token,refresh_token:refresh_tokenxx

-> Headers -> Content-Type:application/x-www-form-urlencoded

**Get Refresh Token With Curl Link**

curl -X POST \
  http://127.0.0.1:8080/oauth/token \
  -H ': ' \
  -H 'Accept: */*' \
  -H 'Accept-Encoding: gzip, deflate' \
  -H 'Authorization: Basic dGVzdEltZGJDbGllbnRJZDppbWRiLXRlc3Qtc2VjcmV0LWtleQ==' \
  -H 'Cache-Control: no-cache' \
  -H 'Connection: keep-alive' \
  -H 'Content-Length: 689' \
  -H 'Content-Type: application/x-www-form-urlencoded' \
  -H 'Host: 127.0.0.1:8080' \
  -H 'User-Agent: PostmanRuntime/7.16.3' \
  -H 'cache-control: no-cache' \
  -H 'content-type: multipart/form-data; boundary=----WebKitFormBoundary7MA4YWxkTrZu0gW' \
  -F grant_type=refresh_token \
  -F refresh_token=eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyX25hbWUiOiJlbXJleWFsY2luIiwic2NvcGUiOlsicmVhZCIsIndyaXRlIiwidHJ1c3QiXSwiYXRpIjoiOWZmODg3MjktMWU0MS00ZTBlLWEzZjQtNWEyY2Y1ZDQ1N2NjIiwiZXhwIjoxNTY3NDc3NDYxLCJhdXRob3JpdGllcyI6WyJST0xFX0FETUlOIiwiUk9MRV9VU0VSIl0sImp0aSI6Ijg5MzAzMDkwLTk4MjktNGNhMS04YTViLTdjZGMxMTQ5MDcwMSIsImNsaWVudF9pZCI6InRlc3RJbWRiQ2xpZW50SWQifQ.WNgsdTaxufaeIFQRWkmHV73JmRJfTStC5U9hMwxdvRY


**EndPoint query**

-> Post Url: 127.0.0.1:8080/oauth/token

-> Authorization -> Oauth2 -> accesstoken

**EndPoint query With Link**

curl -X GET \
  http://127.0.0.1:8080/imdb/search/matrix/1 \
  -H 'Accept: */*' \
  -H 'Accept-Encoding: gzip, deflate' \
  -H 'Authorization: Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJleHAiOjE1Njc0OTEzNzYsInVzZXJfbmFtZSI6ImVtcmV5YWxjaW4iLCJhdXRob3JpdGllcyI6WyJST0xFX0FETUlOIiwiUk9MRV9VU0VSIl0sImp0aSI6ImFhNDlhMjViLWIyZWYtNDA3OC1hMzg5LWIyODE5YWI0ZjZhMyIsImNsaWVudF9pZCI6InRlc3RJbWRiQ2xpZW50SWQiLCJzY29wZSI6WyJyZWFkIiwid3JpdGUiLCJ0cnVzdCJdfQ.J5uyUPnJGZZZAiixeW1OpZAKvgWfntqwT0ijbmhDzkU' \
  -H 'Cache-Control: no-cache' \
  -H 'Connection: keep-alive' \
  -H 'Host: 127.0.0.1:8080' \
  -H 'User-Agent: PostmanRuntime/7.16.3' \
  -H 'cache-control: no-cache'
  
  