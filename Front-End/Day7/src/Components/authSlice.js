// authSlice.js

import { createSlice } from '@reduxjs/toolkit';

const initialState = {
  isAuthenticated: false,
  user: null,
};

const authSlice = createSlice({
  name: 'auth',
  initialState,
  reducers: {
    login: (state, action) => {
      state.isAuthenticated = true;
      state.user = action.payload;
    },
    logout: (state) => {
      state.isAuthenticated = false;
      state.user = null;
    },
    setUserName: (state, action) => {
      state.user = { ...state.user, name: action.payload };
    },
  },
});

export const { login, logout, setUserName } = authSlice.actions;

export default authSlice.reducer;
