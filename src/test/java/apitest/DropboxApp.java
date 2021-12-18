package apitest;

import kong.unirest.HttpResponse;
import kong.unirest.JsonNode;
import kong.unirest.Unirest;

import java.io.File;
import java.util.HashMap;
import java.util.Map;


public  class DropboxApp {
    private final String oauth_key = "voZPgFB6EoMAAAAAAAAAAc5YHGDR9DpYLEYQrY6VPFGLjLBj4MHATY4oJDIr7kaF";

    private final Map<String, HttpResponse<JsonNode>> lastResponses = new HashMap<>();

    public HttpResponse<JsonNode> uploadFile(File file) {
        return lastResponses.put(file.getAbsolutePath(), Unirest.post("https://content.dropboxapi.com/2/files/upload")
                .header("Dropbox-API-Arg", "{\"path\": \"/NewFile.txt\",\"mode\": \"add\",\"autorename\": true,\"mute\": false,\"strict_conflict\": false}")
                .header("Content-Type", "application/octet-stream")
                .header("Authorization", "Bearer voZPgFB6EoMAAAAAAAAAAc5YHGDR9DpYLEYQrY6VPFGLjLBj4MHATY4oJDIr7kaF")
                .body(file.getAbsolutePath()).asJson());
    }

    public HttpResponse<JsonNode> getFileMetadata(File file) {
        return lastResponses.put(file.getAbsolutePath(), Unirest.post("https://content.dropboxapi.com/2/sharing/get_file_metadata")
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer voZPgFB6EoMAAAAAAAAAAc5YHGDR9DpYLEYQrY6VPFGLjLBj4MHATY4oJDIr7kaF")
                .body("{\r\n    \"file\": \"id:CZnzKLbN-MMAAAAAAAAADA\",\r\n    \"actions\":[]\r\n}")
                .asObject(JsonNode.class));
    }

    public HttpResponse<JsonNode> deleteFile(File file) {
        return lastResponses.put(file.getAbsolutePath(), Unirest.post("https://content.dropboxapi.com/2/files/delete_v2")
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer voZPgFB6EoMAAAAAAAAAAc5YHGDR9DpYLEYQrY6VPFGLjLBj4MHATY4oJDIr7kaF")
                .body("{\r\n    \"path\": \"/NewFile.txt\"\r\n}")
                .asObject(JsonNode.class));
    }

    private String getFileId(File file) {
        return lastResponses.get(file.getAbsolutePath()).getBody().getObject().getString("id");
    }

    public HttpResponse<JsonNode> getLastResponse(String file) {
        return lastResponses.get(file);
    }
}
