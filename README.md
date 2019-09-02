# Develop a REST API to moderate/validate the comment text to prevent customers from posting objectionable content. </br>
 The REST API is expected to take a piece of text as an input and respond with feedback regarding objectionable content.</br>
</br>
</br>
[POST] http://localhost:8080/product/{productId}/comment/{commentId} </br>
</br>
</br>
Request Header</br>
"content-type": "application/json"</br>
</br>
</br>
Request Payload</br>
{</br>
	"commetId": "{comment-id}",</br>
	"commets": "{comment-text}"</br>
}</br>
</br>
</br>
Success Response (200 OK)</br>
{</br>
    "status": true,</br>
    "data": {</br>
        "productId": "{product-id}",</br>
        "comment": "{comment-text}",</br>
        "objectionable": "{true/false}"</br>
    }</br>
}</br>
</br>
</br>
Success Response (200 OK)</br>
{
    "message": "Success",</br>
    "returnCode": 0,</br>
    "result": {</br>
        "commetId": "{comment-id}",</br>
        "productId": "{product-id}",</br>
        "commets": "{comment-text}",</br>
        "objectionable": "{true/false}"</br>
    }</br>
}</br>
</br>
</br>
Method Not Allowed(405)</br>
{</br>
    "timestamp": "2019-09-02T12:51:26.755+0000",</br>
    "status": 405,</br>
    "error": "Method Not Allowed",</br>
    "message": "Request method 'GET' not supported",</br>
    "path": "/product/p123/comment"</br>
}</br>
</br>
</br>
Failiure Response (500 Internal Server Error)</br>
{</br>
    "timestamp": "{current-time}",</br>
    "status": 500,</br>
    "error": "Internal Server Error",</br>
    "message": "{failiure-reason}",</br>
    "path": "{product path}"</br>
}</br>
