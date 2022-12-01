import { Link } from "react-router-dom";

import classes from "./MainNavigation.module.css";

function MainNavigation() {
  return (
    <header className={classes.header}>
      <div className={classes.logo}>CRM</div>
      <nav>
        <ul>
          <li>
            <Link to="/plannedActions">Planned actions</Link>
          </li>
          <li>
            <Link to="/opportunities">Opportunities</Link>
          </li>
        </ul>
      </nav>
    </header>
  );
}

export default MainNavigation;
