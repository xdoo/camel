/*
 * Copyright 2014 claus.straube.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.camel.dataformat.code;

import java.util.Map;

/**
 * All configuration parameters for the code component.
 * 
 * @author claus.straube
 */
public class Parameters {
    
    /**
     * The Image Type. Default is PNG.
     */
    private ImageType type;
    
    /**
     * The width of the image. Default is 100px.
     */
    private Integer width;
    
    /**
     * The height of the image. Default is 100px.
     */
    private Integer height;
    
    /**
     * The message encoding. Default is UTF-8.
     */
    private String encoding;

    /**
     * Default construtor creates default values.
     */
    public Parameters(ImageType type, Integer width, Integer height, String encoding) {
        this.encoding = encoding;
        this.height = height;
        this.width = width;
        this.type = type;
    }
    
    /**
     * Parameter bean with given header.
     * 
     * @param headers the camel message headers 
     */
    public Parameters(Map<String,Object> headers, Parameters params) {
        this.setParameters(headers, params);
    }
    
    private void setParameters(Map<String,Object> headers, Parameters params) {
        
        if(headers.containsKey(Code.HEIGHT)) {
            this.setHeight((Integer) headers.get(Code.HEIGHT));
        } else {
            this.setHeight(params.getHeight());
        }
        
        if(headers.containsKey(Code.WIDTH)) {
            this.setWidth((Integer) headers.get(Code.WIDTH));
        } else {
            this.setWidth(params.getWidth());
        }
        
        if(headers.containsKey(Code.IMAGE_TYPE)) {
            this.setType((ImageType) headers.get(Code.IMAGE_TYPE));
        } else {
            this.setType(params.getType());
        }
        
        if(headers.containsKey(Code.ENCODING)){
            this.setEncoding((String) headers.get(Code.ENCODING));
        } else {
            this.setEncoding(params.getEncoding());
        }
        
    }

    public ImageType getType() {
        return type;
    }

    public void setType(ImageType type) {
        this.type = type;
    }

    public Integer getWidth() {
        return width;
    }

    public void setWidth(Integer width) {
        this.width = width;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public String getEncoding() {
        return encoding;
    }

    public void setEncoding(String encoding) {
        this.encoding = encoding;
    }
    
}