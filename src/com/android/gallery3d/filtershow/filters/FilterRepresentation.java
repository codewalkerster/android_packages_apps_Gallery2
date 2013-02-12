/*
 * Copyright (C) 2013 The Android Open Source Project
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

package com.android.gallery3d.filtershow.filters;

import com.android.gallery3d.app.Log;
import com.android.gallery3d.filtershow.editors.BasicEditor;
import com.android.gallery3d.filtershow.presets.ImagePreset;

public class FilterRepresentation implements Cloneable {
    private static final String LOGTAG = "FilterRepresentation";
    private String mName;
    private int mPriority = TYPE_NORMAL;
    private ImagePreset mPreset;
    private Class mFilterClass;
    private int mTextId = 0;
    private int mEditorId = BasicEditor.ID;
    private int mButtonId = 0;
    private int mOverlayId = 0;
    private boolean mShowEditingControls = true;
    private boolean mShowParameterValue = true;
    private boolean mShowUtilityPanel = true;

    public static final byte TYPE_BORDER = 1;
    public static final byte TYPE_FX = 2;
    public static final byte TYPE_WBALANCE = 3;
    public static final byte TYPE_VIGNETTE = 4;
    public static final byte TYPE_NORMAL = 5;
    public static final byte TYPE_TINYPLANET = 6;

    public FilterRepresentation(String name) {
        mName = name;
    }

    @Override
    public FilterRepresentation clone() throws CloneNotSupportedException {
        FilterRepresentation representation = (FilterRepresentation) super.clone();
        representation.setName(getName());
        representation.setPriority(getPriority());
        representation.setFilterClass(getFilterClass());
        representation.setTextId(getTextId());
        representation.setEditorId(getEditorId());
        representation.setButtonId(getButtonId());
        representation.setOverlayId(getOverlayId());
        representation.setShowEditingControls(showEditingControls());
        representation.setShowParameterValue(showParameterValue());
        representation.setShowUtilityPanel(showUtilityPanel());
        Log.v(LOGTAG, "cloning from <" + this + "> to <" + representation + ">");
        return representation;
    }

    public boolean equals(FilterRepresentation representation) {
        if (representation == null) {
            return false;
        }
        if (representation.mFilterClass == representation.mFilterClass
                && representation.mName.equalsIgnoreCase(mName)
                && representation.mPriority == mPriority
                && representation.mTextId == mTextId
                && representation.mEditorId == mEditorId
                && representation.mButtonId == mButtonId
                && representation.mOverlayId == mOverlayId
                && representation.mShowEditingControls == mShowEditingControls
                && representation.mShowParameterValue == mShowParameterValue
                && representation.mShowUtilityPanel == mShowUtilityPanel) {
            return true;
        }
        return false;
    }

    public String toString() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public String getName() {
        return mName;
    }

    public void setPriority(int priority) {
        mPriority = priority;
    }

    public int getPriority() {
        return mPriority;
    }

    public void setImagePreset(ImagePreset preset) {
        mPreset = preset;
    }

    public boolean isNil() {
        return false;
    }

    public void useParametersFrom(FilterRepresentation a) {
    }

    public boolean allowsMultipleInstances() {
        return false;
    }

    public Class getFilterClass() {
        return mFilterClass;
    }

    public void setFilterClass(Class filterClass) {
        mFilterClass = filterClass;
    }

    public boolean same(FilterRepresentation b) {
        if (b == null) {
            return false;
        }
        return getFilterClass() == b.getFilterClass();
    }

    public int getTextId() {
        return mTextId;
    }

    public void setTextId(int textId) {
        mTextId = textId;
    }

    public int getButtonId() {
        return mButtonId;
    }

    public void setButtonId(int buttonId) {
        mButtonId = buttonId;
    }

    public int getOverlayId() {
        return mOverlayId;
    }

    public void setOverlayId(int overlayId) {
        mOverlayId = overlayId;
    }

    public int getEditorId() {
        return mEditorId;
    }

    public void setEditorId(int editorId) {
        mEditorId = editorId;
    }

    public boolean showEditingControls() {
        return mShowEditingControls;
    }

    public void setShowEditingControls(boolean showEditingControls) {
        mShowEditingControls = showEditingControls;
    }

    public boolean showParameterValue() {
        return mShowParameterValue;
    }

    public void setShowParameterValue(boolean showParameterValue) {
        mShowParameterValue = showParameterValue;
    }

    public boolean showUtilityPanel() {
        return mShowUtilityPanel;
    }

    public void setShowUtilityPanel(boolean showUtilityPanel) {
        mShowUtilityPanel = showUtilityPanel;
    }
}