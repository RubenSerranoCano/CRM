import Card from "../ui/Card";
import classes from "./PlannedActionItem.module.css";
import Moment from "moment";

function PlannedActionItem(props) {
  const formattedDate = Moment(props.dueDateTime).format(
    "MMM Do YYYY @ HH:mm:ss"
  );

  return (
    <li className={classes.item}>
      <Card>
        <div className={classes.content}>
          <h3>{props.client?.name}</h3>
          <p>{props.description}</p>
        </div>
        <div className={classes.actions}>
          <h3>
            {props.actionType} - {props.statusType}
          </h3>
          <h3>{formattedDate}</h3>
          <div className={classes.actions}>
            <button>Cancel</button>
          </div>
        </div>
      </Card>
    </li>
  );
}

export default PlannedActionItem;