package com.adgvit.papervit2.Object;

public class ServerResponse {
    PaperMetadata metadata;

    public ServerResponse(PaperMetadata metadata) {
        this.metadata = metadata;
    }

    public PaperMetadata getMetadata() {
        return metadata;
    }

    public void setMetadata(PaperMetadata metadata) {
        this.metadata = metadata;
    }
}
