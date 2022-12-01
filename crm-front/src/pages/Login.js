import { useState } from "react";
import { useNavigate } from "react-router-dom";
import "./Login.css";

function Login() {
  const [loginForm, setLoginForm] = useState({ email: "", password: "" });

  const [errorMessage, setErrorMessage] = useState();

  const navigate = useNavigate();

  const onLoginHandler = (event) => {
    event.preventDefault();

    const requestOptions = {
      method: "POST",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify({
        email: loginForm.email,
        password: loginForm.password,
      }),
    };
    fetch("http://localhost:8090/api/v1/login", requestOptions).then(
      (response) => {
        if (response.ok) {
          localStorage.setItem("accessToken", "X5#$Y3hRzkH1");
          navigate("/plannedActions");
        } else {
          setErrorMessage("Invalid user or password");
        }
      }
    );
  };

  const onSignupHandler = (event) => {
    event.preventDefault();

    const requestOptions = {
      method: "POST",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify({
        email: loginForm.email,
        password: loginForm.password,
      }),
    };

    fetch("http://localhost:8090/api/v1/signup", requestOptions)
      .then((response) => response.json())
      .then((responseData) => {
        console.log(responseData);
        if (responseData.ok) {
          navigate("/");
        } else if (responseData.email === loginForm.email && responseData.password === "") {
          setErrorMessage("You are already signed up");
        } else {
          setErrorMessage("Invalid email or password.");
        }
      });
  };

  return (
    <div>
      <div className="box-root padding-top--48 padding-bottom--24 flex-flex flex-justifyContent--center">
        <h1>
          <a href="/">Assessment CRM</a>
        </h1>
      </div>
      <div className="formbg-outer">
        <div className="formbg">
          <div className="formbg-inner padding-horizontal--48">
            <form id="stripe-login">
              <span className="padding-bottom--15">Log in</span>
              <div className="field padding-bottom--24">
                <label htmlFor="email">Email</label>
                <input
                  type="email"
                  name="email"
                  onChange={(e) => {
                    setLoginForm({ ...loginForm, email: e.target.value });
                  }}
                  required
                />
              </div>
              <div className="field padding-bottom--24">
                <div className="grid--50-50">
                  <label htmlFor="password">Password</label>
                </div>
                <input
                  type="password"
                  name="password"
                  onChange={(e) => {
                    setLoginForm({ ...loginForm, password: e.target.value });
                  }}
                  required
                />
              </div>
              <div className="field field-checkbox padding-bottom--24 flex-flex align-center">
                <label htmlFor="checkbox">
                  <input type="checkbox" name="checkbox" /> Remember me
                </label>
              </div>
              <span className="padding-bottom--15">
                {errorMessage && <div>{errorMessage}</div>}
              </span>
              <div className="field padding-bottom--24">
                <input
                  type="submit"
                  name="submit"
                  value="Log in"
                  onClick={onLoginHandler}
                  disabled={loginForm.email === "" || loginForm.password === ""}
                />
              </div>
              <div className="field">
                <input
                  type="button"
                  name="button"
                  value="Sign up"
                  onClick={onSignupHandler}
                  disabled={loginForm.email === "" || loginForm.password === ""}
                />
              </div>
            </form>
          </div>
        </div>
      </div>
    </div>
  );
}

export default Login;