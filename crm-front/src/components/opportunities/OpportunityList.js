import OpportunityItem from "./OpportunityItem";
import classes from "./OpportunityList.module.css";

function OpportunityList(props) {
    console.log(props.opportunities);
    return(
        <div>
            <ul className={classes.list}>
                {props.opportunities.map((opportunity) =>(
                    <OpportunityItem
                        key={opportunity.id}
                        id={opportunity.id}
                        client={opportunity.client}
                        name={opportunity.name}
                        statusType={opportunity.statusType}
                        plannedActionsList={opportunity.plannedActionsList}
                    ></OpportunityItem>
                ))}
            </ul>
        </div>
    );
}

export default OpportunityList;
