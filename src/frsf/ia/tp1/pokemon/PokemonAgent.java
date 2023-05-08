package frsf.ia.tp1.pokemon;

import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

import frsf.cidisi.faia.agent.Action;
import frsf.cidisi.faia.agent.Perception;
import frsf.cidisi.faia.agent.search.Problem;
import frsf.cidisi.faia.agent.search.SearchAction;
import frsf.cidisi.faia.agent.search.SearchBasedAgent;
import frsf.cidisi.faia.solver.search.BreathFirstSearch;
import frsf.cidisi.faia.solver.search.DepthFirstSearch;
import frsf.cidisi.faia.solver.search.IStepCostFunction;
import frsf.cidisi.faia.solver.search.Search;
import frsf.ia.tp1.pokemon.actions.Curarse;
import frsf.ia.tp1.pokemon.actions.Escapar;
import frsf.ia.tp1.pokemon.actions.MoverANodo;
import frsf.ia.tp1.pokemon.actions.Pelear;
import frsf.ia.tp1.pokemon.actions.UsarAtaqueEspecial;

public class PokemonAgent extends SearchBasedAgent{
	
	public PokemonAgent() {
		
		PokemonGoal goal = new PokemonGoal();
		
		PokemonAgentState pokemonAgentState = new PokemonAgentState();
		this.setAgentState(pokemonAgentState);
		
		Vector<SearchAction> operators = new Vector<SearchAction>();
		
		// Operadores mover a nodo
		for (int i = 1; i <= Const.cantidadNodos; i++) {
			operators.addElement(new MoverANodo(i));
		}
		
		// Operadores Usar Ataque Especial
		operators.addElement(new UsarAtaqueEspecial(0, Const.porcentajeRecuperacionEnergiaAtaque0));
		operators.addElement(new UsarAtaqueEspecial(1, Const.porcentajeRecuperacionEnergiaAtaque1));
		operators.addElement(new UsarAtaqueEspecial(2, Const.porcentajeRecuperacionEnergiaAtaque2));
		
		operators.addElement(new Curarse());
		operators.addElement(new Pelear());
		operators.addElement(new Escapar());
		
		Problem problem = new Problem(goal, pokemonAgentState, operators);
		this.setProblem(problem);
		
	}

	@Override
	public void see(Perception p) {
		this.getAgentState().updateState(p);
	}

	@Override
	public Action selectAction() {
		
//		IStepCostFunction costFunction = new CostFunction();
//        UniformCostSearch strategy = new UniformCostSearch(costFunction);
//		DepthFirstSearch strategy = new DepthFirstSearch();
		BreathFirstSearch strategy = new BreathFirstSearch();

		// Create a Search object with the strategy
        Search searchSolver = new Search(strategy);

        /* Generate an XML file with the search tree. It can also be generated
         * in other formats like PDF with PDF_TREE */
        searchSolver.setVisibleTree(Search.EFAIA_TREE);

        // Set the Search searchSolver.
        this.setSolver(searchSolver);

        // Ask the solver for the best action
        Action selectedAction = null;
        try {
            selectedAction =
                    this.getSolver().solve(new Object[]{this.getProblem()});
        } catch (Exception ex) {
            Logger.getLogger(PokemonAgent.class.getName()).log(Level.SEVERE, null, ex);
        }

        // Return the selected action
        return selectedAction;
	}

}
