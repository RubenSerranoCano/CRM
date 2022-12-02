import Moment from "moment";
import classes from "./OpportunityItem.module.css";

function OpportunityItem(props) {
  return (
    <li className={classes.item}>
      <div>
        <h3>{props.client?.name}</h3>
        <p>{props.name}</p>
      </div>
      <div>
        <h3>{props.statusType}</h3>
      </div>
      <h3>Planned actions</h3>
      <table>
        <tbody>
          <tr>
            <th>Action</th>
            <th>Description</th>
            <th>statusType</th>
            <th>Due</th>
            <th>Client</th>
          </tr>
          {props.plannedActionList?.map((plannedAction) => {
            const formattedDueDateTime = Moment(props.dueDateTime).format(
              "MMM Do YYYY @ HH:mm:ss"
            );
            return (
              <tr>
                <td>{plannedAction.actionType}</td>
                <td>{plannedAction.description}</td>
                <td>{plannedAction.statusType}</td>
                <td>{formattedDueDateTime}</td>
                <td>{plannedAction.client?.name}</td>
              </tr>
            );
          })}
        </tbody>
      </table>
    </li>
  );
}

export default OpportunityItem;
