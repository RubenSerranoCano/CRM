import PlannedActionItem from "./PlannedActionItem";
import classes from "./PlannedActionList.module.css";

function PlannedActionList(props) {
  console.log(props.plannedActions);
  return (
    <div>
      <ul className={classes.list}>
        {props.plannedActions.map((plannedAction) => (
          <PlannedActionItem
            key={plannedAction.id}
            id={plannedAction.id}
            actionType={plannedAction.actionType}
            description={plannedAction.description}
            statusType={plannedAction.statusType}
            dueDateTime={plannedAction.dueDateTime}
            client={plannedAction.client}
          />
        ))}
      </ul>
    </div>
  );
}

export default PlannedActionList;
